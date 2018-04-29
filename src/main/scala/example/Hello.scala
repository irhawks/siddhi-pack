package example

import org.wso2.siddhi.core.SiddhiAppRuntime
import org.wso2.siddhi.core.SiddhiManager
import org.wso2.siddhi.core.event.Event
import org.wso2.siddhi.core.stream.input.InputHandler
import org.wso2.siddhi.core.stream.output.StreamCallback
import org.wso2.siddhi.core.util.EventPrinter

object Hello extends App {

  val query_string1 = """
  define stream StockEventStream (symbol string, price float, volume long);
  @info(name = 'query1')
  from StockEventStream#window.time(5 sec)
  select symbol, sum(price) as price, sum(volume) as volume
  group by symbol
  insert into AggregateStockStream;
  """

  val query_string2 = """
  @source(type='kafka',
    topic.list='topic1',
    partition.no.list='0',
    threading.option='single.thread',
    group.id="group",
    bootstrap.servers='192.168.11.187:9092',
    @map(type='json'))
  define stream SweetProductionStream (name string, amount double);

  @sink(type='kafka',
    topic='kafka_result_topic',
    bootstrap.servers='localhost:9092',
    partition.no='0',
    @map(type='json'))
  define stream LowProductionAlertStream (name string, amount double);

  --Send events in a length window of 5 from kafka_topic to kafka_result_topic
  @info(name='query1')
  from SweetProductionStream#window.length(5)
  select *
  insert into LowProductionAlertStream;
  """

  val siddhiManager = new SiddhiManager()
  val siddhiAppRuntime = siddhiManager.createSiddhiAppRuntime(query_string2) 

  siddhiAppRuntime.addCallback("LowProductionAlertStream",
    new StreamCallback() {
      override def receive(events : Array[Event]): Unit = {
        EventPrinter.print(events)
      }     
    }) 
  //Starting event processing
  siddhiAppRuntime.start()

  Thread.sleep(1000)
}

