package org.irhawks.streaming.siddhi

import org.wso2.siddhi.core.SiddhiAppRuntime
import org.wso2.siddhi.core.SiddhiManager
import org.wso2.siddhi.core.event.Event
import org.wso2.siddhi.core.stream.input.InputHandler
import org.wso2.siddhi.core.stream.output.StreamCallback
import org.wso2.siddhi.core.util.EventPrinter

// 'commons-io:commons-io:jar:2.6'
import org.apache.commons.io.FileUtils
import java.nio.charset.StandardCharsets

object SiddhiStandalone {

  // option parser
  import java.io.File
  case class CliArgument(time: Int = 10*1000, file: File = new File("input.siddhi"))

  val parser = new scopt.OptionParser[CliArgument]("SiddhiStandalone") {
    head("SiddhiStandalone", "0.1.0")
    opt[Int]('t', "time")
      .action( (x, c) => c.copy(time=x) )
      .text("运行时间（默认10分钟）")

      arg[File]("<file>...").unbounded().required()
        .action( (x,c) => c.copy(file = x))
        .text("文件名")
  }

  def main(args: Array[String]) : Unit = {

    parser.parse(args, CliArgument()) match {

      case Some(cliArgument) => 
        // println("Correct")
        println(s"Running Stream query file ${cliArgument.file} for ${cliArgument.time} seconds")
        runSiddhi(
          FileUtils.readFileToString(cliArgument.file, StandardCharsets.UTF_8),
          cliArgument.time)

      case None => println("Error")

    }
  }

  def runSiddhi(queryString: String, duration: Int = 1000*10) = {

    val siddhiManager = new SiddhiManager()
    val siddhiAppRuntime = siddhiManager.createSiddhiAppRuntime(queryString) 

    // Starting event processing
    siddhiAppRuntime.start()

    Thread.sleep(duration)
    siddhiAppRuntime.shutdown()
  }
}
