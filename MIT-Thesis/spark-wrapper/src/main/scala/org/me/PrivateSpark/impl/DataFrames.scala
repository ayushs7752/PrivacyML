
package org.me.PrivateSpark.impl
import org.me.PrivateSpark.NoiseMechanisms.laplace

import scala.reflect.ClassTag

class Lap_Dataframe[T](
                                 , info: QueryInfo
                                 , enforcement : Single_Enforcement
                                 

  override def count() : Double = {
    def budget = info.budget
    if (budget.charge(info.outputs * budget.epsilon)) {
      def sensitivity = 1.0
      def scale = sensitivity / budget.epsilon
      dataframe.count() + laplace(scale)
    } else {
      throw new IllegalStateException("Privacy budget exceeded!")
    }
  }

  override def sum() : Double = {
    throw new UnsupportedOperationException("Not permitted!")
  }
  override def avg() : Double = {
    throw new UnsupportedOperationException("Not permitted!")
  }

}