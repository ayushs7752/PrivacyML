/** AsymLap */
def asymlaplace(scale: Double, asym : Double): Double = {
    val u = 0.5 - scala.util.Random.nextDouble()
    val s=math.signum(u)
    -scale * math.log(math.abs(u)* s *math.pow(asym,s)) / s*math.pow(asym,s)     /** Second constraint to be implemented**/ /**Check for values **/us
  }
  
  /**Laplace**/
  def laplace(scale: Double): Double = {
    val u = 0.5 - scala.util.Random.nextDouble()
    -math.signum(u) * scale * math.log(1 - 2*math.abs(u)) 
  }
/** Staricase - 1 - Unoptimized - trial check **/
def optimalNoise(epsilon:Double, sensitivity:Double,gamma:Double): Double =
{
        var S= 0
        var B= 0
       // val n=1- scala.math.pow(2.71,-epsilon)
        //val d=2*delta*(2+ scala.math.pow(2.71,-epsilon))
        /* Basic Implementation
        val first=1/scala.math.pow(2.71,epsilon)
        val nr= 1-first
        val gamma=0.5
        val second=0.5+first*0.5
        val dr=2*delta*second
        println(nr/dr)
        nr/dr
        */
       if(scala.util.Random.nextDouble()>0.5)
        {
             S = 1
        }
        else
        {
             S = -1
        }
        val i= scala.util.Random.nextInt(100) 
        val epsE=1/scala.math.pow(2.71,epsilon)
        val G= (1-epsE)*scala.math.pow(epsE,i)
        val U=scala.util.Random.nextDouble()
        val B1= gamma/(gamma+ (1- gamma)*epsE)
        val B2=(1-gamma)*epsE/(gamma+(1 - gamma)*epsE)
        /* To be generalized */
        if(scala.util.Random.nextDouble()>0.5)
        {
             B = 0
        }
        else
        {
             B = 1
        }
        val X= S * ((1-B)*(G+gamma*U)*sensitivity) + B*((G+gamma+(1-gamma)*U)*sensitivity)
        X
        
}