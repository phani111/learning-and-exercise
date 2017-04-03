import org.apache.spark.SparkContext

class Aggregations (sc : SparkContext) {
   def aggregate () = {
        val data = Array(1,2,3,4,5,6)
        val rdd = sc.parallelize(data)
        // sum
        rdd.aggregate(0)((x, y) => x + y, (a, b) => a + b)
        // sum and count
        rdd.aggregate((0, 0))((x, y) => (x._1 + y, x._2 + 1), (a, b) => (a._1 + b._1, a._2 + b._2))
    }

    def fold () = {
        val data = Array(1,2,3,4,5,6)
        val rdd = sc.parallelize(data)
        val result = rdd.fold(0)((a, b) => a + b)
    }

    def reduce () = [
        val data = Array(1,2,3,4,5,6)
        val rdd = sc.parallelize(data)
        val result = rdd.reduce((a, b) => a + b)
    ]
}