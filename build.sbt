import Dependencies._

lazy val root = (project in file(".")).
settings(
    inThisBuild(List(
        organization := "com.example",
        scalaVersion := "2.12.6",
        version      := "0.1.0-SNAPSHOT"
        )),
    name := "siddhi-all",
    libraryDependencies += scalaTest % Test,
    libraryDependencies += "com.github.scopt" %% "scopt" % "3.7.0",
    libraryDependencies ++= Seq(
      "commons-io" % "commons-io" % "2.6",
      "org.apache.commons" % "commons-vfs2" % "2.2",
      "org.wso2.siddhi" % "siddhi-core" % "4.1.17",
      "org.wso2.siddhi" % "siddhi-query-api" % "4.1.17",
      "org.wso2.siddhi" % "siddhi-query-compiler" % "4.1.17",
      "org.wso2.siddhi" % "siddhi-annotations" % "4.1.17"
    ),
    libraryDependencies ++= Seq(
      "org.wso2.extension.siddhi.execution.string" % "siddhi-execution-string" % "4.0.11",
      "org.wso2.extension.siddhi.execution.math" % "siddhi-execution-math" % "4.0.14",
      "org.wso2.extension.siddhi.execution.time" % "siddhi-execution-time" % "4.0.10",
      "org.wso2.extension.siddhi.execution.streamingml" % "siddhi-execution-streamingml" % "1.0.12",
      "org.wso2.extension.siddhi.execution.regex" % "siddhi-execution-regex" % "4.0.10",
      "org.wso2.extension.siddhi.execution.markov" % "siddhi-execution-markov" % "4.0.10",
      "org.wso2.extension.siddhi.execution.unique" % "siddhi-execution-unique" % "4.0.22",
      "org.wso2.extension.siddhi.execution.map" % "siddhi-execution-map" % "4.0.10",
      "org.wso2.extension.siddhi.execution.unitconversion" % "siddhi-execution-unitconversion" % "1.0.11",
      "org.wso2.extension.siddhi.execution.extrema" % "siddhi-execution-extrema" % "4.0.9",
      "org.wso2.extension.siddhi.execution.timeseries" % "siddhi-execution-timeseries" % "4.0.10",
      "org.wso2.extension.siddhi.execution.priority" % "siddhi-execution-priority" % "4.0.8",
      "org.wso2.extension.siddhi.execution.reorder" % "siddhi-execution-reorder" % "4.0.16",
      "org.wso2.extension.siddhi.execution.sentiment" % "siddhi-execution-sentiment" % "4.0.11",
      "org.wso2.extension.siddhi.execution.stats" % "siddhi-execution-stats" % "1.0.10",
      "org.wso2.extension.siddhi.execution.geo" % "siddhi-execution-geo" % "4.0.9",
      "org.wso2.extension.siddhi.execution.kalmanfilter" % "siddhi-execution-kalman-filter" % "4.0.9",
      "org.wso2.extension.siddhi.execution.approximate" % "siddhi-execution-approximate" % "1.0.13",
      "org.wso2.extension.siddhi.execution.graph" % "siddhi-execution-graph" % "1.0.7",
      "org.wso2.extension.siddhi.execution.tensorflow" % "siddhi-execution-tensorflow" % "1.0.1",
      "org.wso2.extension.siddhi.execution.env" % "siddhi-execution-env" % "1.0.1"
      ),
      libraryDependencies ++= Seq(
          "org.wso2.extension.siddhi.io.http" % "siddhi-io-http" % "1.0.18",
          "org.wso2.extension.siddhi.io.kafka" % "siddhi-io-kafka" % "4.1.6",
          "org.wso2.extension.siddhi.io.tcp" % "siddhi-io-tcp" % "2.0.15",
          "org.wso2.extension.siddhi.io.wso2event" % "siddhi-io-wso2event" % "4.0.12",
          "org.wso2.extension.siddhi.io.email" % "siddhi-io-email" % "1.0.12",
          "org.wso2.extension.siddhi.io.jms" % "siddhi-io-jms" % "1.0.22",
          "org.wso2.extension.siddhi.io.file" % "siddhi-io-file" % "1.0.6",
          "org.wso2.extension.siddhi.io.rabbitmq" % "siddhi-io-rabbitmq" % "1.0.14",
          "org.wso2.extension.siddhi.io.mqtt" % "siddhi-io-mqtt" % "1.0.17",
          "org.wso2.extension.siddhi.io.websocket" % "siddhi-io-websocket" % "1.0.5",
          ),
      libraryDependencies ++= Seq(
          "org.wso2.extension.siddhi.map.json" % "siddhi-map-json" % "4.0.20",
          "org.wso2.extension.siddhi.map.xml" % "siddhi-map-xml" % "4.0.11",
          "org.wso2.extension.siddhi.map.binary" % "siddhi-map-binary" % "1.0.10",
          "org.wso2.extension.siddhi.map.text" % "siddhi-map-text" % "1.0.14",
          "org.wso2.extension.siddhi.map.wso2event" % "siddhi-map-wso2event" % "4.0.10",
          "org.wso2.extension.siddhi.map.keyvalue" % "siddhi-map-keyvalue" % "1.0.10",
          "org.wso2.extension.siddhi.map.csv" % "siddhi-map-csv" % "1.0.3",
          ),
      libraryDependencies ++= Seq(
          "org.wso2.extension.siddhi.store.rdbms" % "siddhi-store-rdbms" % "4.0.18",
          "org.wso2.extension.siddhi.store.solr" % "siddhi-store-solr" % "1.0.15",
          "org.wso2.extension.siddhi.store.mongodb" % "siddhi-store-mongodb" % "1.0.13",
          "org.wso2.extension.siddhi.store.hbase" % "siddhi-store-hbase" % "4.0.7",
          "org.wso2.extension.siddhi.store.redis" % "siddhi-store-redis" % "1.0.1",
          "org.wso2.extension.siddhi.store.cassandra" % "siddhi-store-cassandra" % "1.0.3",
          ),
      libraryDependencies ++= Seq(
          "org.wso2.extension.siddhi.script.js" % "siddhi-script-js" % "4.0.8",
          "org.wso2.extension.siddhi.script.scala" % "siddhi-script-scala" % "4.0.1",
          ),
      libraryDependencies ++= Seq(
          "org.wso2.extension.siddhi.gpl.execution.nlp" % "siddhi-gpl-execution-nlp" % "4.0.10",
          "org.wso2.extension.siddhi.gpl.execution.pmml" % "siddhi-gpl-execution-pmml" % "4.0.13",
          "org.wso2.extension.siddhi.gpl.execution.geo" % "siddhi-gpl-execution-geo" % "4.0.10",
          "org.wso2.extension.siddhi.gpl.execution.r" % "siddhi-gpl-execution-r" % "4.0.8",
          "org.wso2.extension.siddhi.gpl.execution.streamingml" % "siddhi-gpl-execution-streamingml" % "1.0.13"
          ),

      assemblyMergeStrategy in assembly := {
        case x if Assembly.isConfigFile(x) =>
          MergeStrategy.concat
          case PathList(ps @ _*) if Assembly.isReadme(ps.last) || Assembly.isLicenseFile(ps.last) =>
          MergeStrategy.rename
        case PathList("META-INF", xs @ _*) =>
          (xs map {_.toLowerCase}) match {
            case ("manifest.mf" :: Nil) | ("index.list" :: Nil) | ("dependencies" :: Nil) =>
              MergeStrategy.discard
            case ps @ (x :: xs) if ps.last.endsWith(".sf") || ps.last.endsWith(".dsa") =>
                MergeStrategy.discard
            case "plexus" :: xs =>
                  MergeStrategy.discard
            case "services" :: xs =>
                    MergeStrategy.filterDistinctLines
            case ("spring.schemas" :: Nil) | ("spring.handlers" :: Nil) =>
                      MergeStrategy.filterDistinctLines
                        case _ => MergeStrategy.first
          }
          case _ => MergeStrategy.first
      }
)




