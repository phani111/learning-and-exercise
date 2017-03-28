package org.learning.spark.mongo

import org.apache.spark.sql.SparkSession
import com.mongodb.spark._
import com.mongodb.spark.config._
import org.bson.Document
import org.apache.spark.sql.functions._

class MongoDataFrame (private val spark : SparkSession) {
    import spark.imlicits._
    private val uri : String = "mongodb://user:pass@node1:27017,node2:27017,node3:27017/?replicaSet=rpSetName&&authSource=authdb"

    def readAndSaveAsTextFile : Unit = {
        val readConfig = ReadConfig(Map("uri" -> uri, "database" -> "cas","collection" -> "msdn_technet_questions"))
        val pageViewDF = MongoSpark.load(spark, readConfig).
            select("_id", "authorId", "forumId", "createdOn", "views")
        pageViewDF.rdd.saveAsTextFile("hdfs://namenode:9000/user/spark/text/pageviews.txt")
    }

    def readPlainDocument : Unit = {
        val readConfig = ReadConfig(Map("uri" -> uri, "database" -> "cas","collection" -> "msdn_technet_questions"))
        val pageViewDF = MongoSpark.load(spark, readConfig).
            select("_id", "authorId", "forumId", "createdOn", "views")
        val authorPageViewDF = pageViewDF.
            select("authorId", "views").
            groupBy("authorId").
            agg(sum("views"))
    }
    def readComplexDocument : Unit = {

    }
}