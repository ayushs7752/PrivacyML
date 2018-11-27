package com.sparkVaik

import org.apache.spark._
import org.apache.spark.SparkContext._
import org.apache.spark.sql._
import org.apache.log4j._

import org.apache.spark.ml.regression.LinearRegression
import org.apache.spark.sql.types._
import org.apache.spark.ml.linalg.Vectors

 import org.apache.spark.mllib.clustering.{KMeans, KMeansModel}


object LinearRegression {
  
    
    def LinReg(file:String )
    {
      Logger.getLogger("org").setLevel(Level.ERROR)
    
      // Use new SparkSession interface in Spark 2.0
      val spark = SparkSession
      .builder
      .appName("Examples")
      .master("local[*]")
     // .config("spark.sql.warehouse.dir", "file:///C:/temp") // Necessary to work around a Windows bug in Spark 2.0.0; omit if you're not on Windows.
      .getOrCreate()
      
     // val inputLines = spark.sparkContext.textFile("../regression.txt")
      val inputLines = spark.sparkContext.textFile(file)
      val data = inputLines.map(_.split(",")).map(x => (x(0).toDouble, Vectors.dense(x(1).toDouble)))
    
    // Convert this RDD to a DataFrame
    import spark.implicits._
    val colNames = Seq("label", "features")
    val df = data.toDF(colNames: _*)
    
    val trainTest = df.randomSplit(Array(0.5, 0.5))
    val trainingDF = trainTest(0)
    val testDF = trainTest(1)
    
    // Now create our linear regression model
    val lir = new LinearRegression()
      .setRegParam(0.3) // regularization 
      .setElasticNetParam(0.8) // elastic net mixing
      .setMaxIter(100) // max iterations
      .setTol(1E-6) // convergence tolerance
    
    // Train the model using our training data
    val model = lir.fit(trainingDF)
    println(s"Coefficients: ${model.coefficients} Intercept: ${model.intercept}")
   
    val fullPredictions = model.transform(testDF).cache()

    
    // Extract the predictions and the "known" correct labels.
    val predictionAndLabel = fullPredictions.select("prediction", "label").rdd.map(x => (x.getDouble(0), x.getDouble(1)))
    
    // Print out the predicted and actual values for each point
   /** for (prediction <- predictionAndLabel) {
      println(prediction)
    }**/
    
    // Stop the session
    spark.stop()
    }
    
    def Kmeans(file:String )
    {
 
    }
    
    def xyz()
    {
    
    }

  
}