import org.apache.spark.{SparkContext,InterruptibleIterator}

class Transformations (sc : SparkContext) {
    def map () = {
        val data = Array(1,2,3,4,5)
        val rdd = sc.parallelize(data)
        rdd.map { i => i + 1 }
        rdd.map { _ + 1}
    }

    def flatMap () = {
        val data = Array("1,2,3", "4,5", "6")
        val rdd = sc.parallelize(data)
        rdd.flatMap { i => i.split(',') } 
        rdd.flatMap ( i => i.split(',') )
        rdd.flatMap { _.split(',') }
    }
}