package org.learning.spark.mongo

import org.apache.spark.sql.SparkSession
import com.mongodb.spark._
import com.mongodb.spark.config._
import org.bson.Document

class SparkWithMongo (private val spark : SparkSession) {
    import spark.imlicits._

    def readPlainDocument : Unit = {
        val readConfig = ReadConfig(
            Map("uri" -> "mongodb://user:pass@node1:27017,node2:27017,node3:27017/database.collection?replicaSet=rpSetName"))
        val collectionDS = MongoSpark.load(spark, readConfig)
    }
    def readComplexDocument : Unit = {
    }
}