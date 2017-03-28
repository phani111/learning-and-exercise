import org.apache.spark.sql.SparkSession

class RDDConcepts (private val sc : SparkContext) {
    import spark.implicits._
    def parallelize () : Unit = {     
        val data = Array(1, 2, 3, 4, 5)
        val distData = sc.parallelize(data)
    }

    def externalDatasets () : Unit = {
        val distFile = sc.textFile("data.txt")
    }
}