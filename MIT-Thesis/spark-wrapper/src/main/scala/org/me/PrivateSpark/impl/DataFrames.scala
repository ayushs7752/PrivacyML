
package org.me.PrivateSpark.impl
import org.me.PrivateSpark.NoiseMechanisms

import scala.reflect.ClassTag

class privateDataframe(filePath : String,
                      epsilon : Double, 
                      noiseType: String, 
                      args: Double*) {

  def sensitivity() { 
    return 1
  }

  def scale(sensitivity : Double) { 
    return sensitivity/this.epsilon
  }

  def privateCompute(operator : String => Array[Double) { 
    val result = operator(this.filePath)

    val sensitivity = this.sensitivity()
    val scale = this.scale(sensitivity)
    val perturbedResult = result.map(x => NoiseMechanism.noiseType(this.args))

    return perturbedResult

  }


// override def count() : Double = {
  //   def budget = info.budget
  //   if (budget.charge(info.outputs * budget.epsilon)) {
  //     def sensitivity = 1.0
  //     def scale = sensitivity / budget.epsilon
  //     dataframe.count() + NoiseMechanisms.noiseType(scale)
  //   } else {
  //     throw new IllegalStateException("Privacy budget exceeded!")
  //   }
  // }

  // override def sum() : Double = {
  //   throw new UnsupportedOperationException("Not permitted!")
  // }
  // override def avg() : Double = {
  //   throw new UnsupportedOperationException("Not permitted!")
  // }

} 