import org.apache.spark.InterruptibleIterator

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

    def aggregate () = {
        val data = Array(1,2,3,4,5,6)
        val rdd = sc.parallelize(data)
        // sum
        rdd.aggregate(0)((x, y) => x + y, (a, b) => a + b)
        // sum and count
        rdd.aggregate((0, 0))((x, y) => (x._1 + y, x._2 + 1), (a, b) => (a._1 + b._1, a._2 + b._2))
    }

    def foreachPartition () = {
        val data = Array(1,2,3,4,5,6)
        val rdd = sc.parallelize(data, 3)
        val newRdd = rdd.foreachPartition { iter =>
            val iterCast : InterruptibleIterator[Int] = iter.asInstanceOf[InterruptibleIterator[Int]]
            val partitionId = iterCast.context.partitionId
            val length = iterCast.length
            println(s"id:$partitionId, length:$length")
            iterCast.map { _ + partitionId }
        }
    }
}