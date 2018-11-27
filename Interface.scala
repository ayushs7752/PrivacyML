package com.sparkVaik

import org.apache.spark._
import org.apache.spark.SparkContext._
import org.apache.spark.sql._
import org.apache.log4j._

import org.apache.spark.ml.regression.LinearRegression
import org.apache.spark.sql.types._
import org.apache.spark.ml.linalg.Vectors

object Interface {
  
  
  /** Our main function where the action happens */
  def main(args: Array[String]) {
    // Set the log level to only print errors
   
   val epsilon=1;
   val k=0.5;
   LinearRegression.LinReg("../regression.txt");
   LinearRegression.xyz();

  }
}