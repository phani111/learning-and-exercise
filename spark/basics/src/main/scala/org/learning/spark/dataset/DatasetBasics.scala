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

    // 3rd party lib: https://github.com/databricks/spark-xml
    // $SPARK_HOME/bin/spark-shell --packages com.databricks:spark-xml_2.11:0.4.1
    def readXMLFile () : Unit = {
        val books = spark.read.
            format("com.databricks.spark.xml").
            option("rowTag", "book").
            load("hdfs://p1.rb.net:9000/user/spark/books.xml")
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