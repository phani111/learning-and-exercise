import org.apache.spark.{SparkContext,InterruptibleIterator}

class BasicConcepts (private val sc : SparkContext) {
    def parallelize () : Unit = {     
        val data = Array(1, 2, 3, 4, 5)
        val distData = sc.parallelize(data)
    }

    def externalDatasets () : Unit = {
        val distFile = sc.textFile("data.txt")
    }

    def getNumPartitions () = {
        val data = Array(1,2,3,4,5,6)
        val rdd = sc.parallelize(data, 3)
        println(rdd.getNumPartitions)
    }

    def foreachPartition () = {
        val data = Array(1,2,3,4,5,6)
        val rdd = sc.parallelize(data, 3)
        rdd.foreachPartition { iter =>
            val iterCast : InterruptibleIterator[Int] = iter.asInstanceOf[InterruptibleIterator[Int]]
            val partitionId = iterCast.context.partitionId
            val length = iterCast.length
            println(s"id:$partitionId, length:$length")
        }
    }
}