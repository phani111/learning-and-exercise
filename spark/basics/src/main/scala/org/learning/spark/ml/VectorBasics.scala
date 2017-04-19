import org.apache.spark.ml.linalg.{Vector, SparseVector, DenseVector}

class VectorBasics {
    def createSparseVector() {
        val sparseVector = new SparseVector(24, Array(0, 1, 2), Array(0.1, 0.2, 0.3))

        // get the ith value
        sparseVector.apply(1)

        // for each active values
        sparseVector.foreachActive((i, v) => { printf("index:%d, value:%f", i, v) })
    }
}