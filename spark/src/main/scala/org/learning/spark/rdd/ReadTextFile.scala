import org.apache.spark.sql.SparkSession

class ReadTextFile (private val spark : SparkSession) {
    import spark.implicits._
    def run () : Unit = {       
    }
}