package org.learning.spark.dataset

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

class DatasetBasics (spark : SparkSession) {
    def readCSVFile () : Unit = {
        val pageViewsDF = spark.
            read.
            option("header", true).
            option("inferSchema", false).
            csv("hdfs://prod1.ca.net:9000/user/spark/csv/msdn_technet_pageviews.csv").
            toDF("id", "authorId", "forumId", "createdOn", "views")
    }

    def castColumnType () : Unit = {
         val pageViewsDF = spark.
            read.
            option("header", true).
            option("inferSchema", false).
            csv("hdfs://prod1.ca.net:9000/user/spark/csv/msdn_technet_pageviews.csv").
            toDF("id", "authorId", "forumId", "createdOn", "views").
            withColumn("views", $"views".cast("int"))
    }
}