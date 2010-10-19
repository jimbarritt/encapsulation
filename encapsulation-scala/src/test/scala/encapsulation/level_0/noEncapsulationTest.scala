package encapsulation.level_0
import org.specs._

class noEncapsulationTest extends Specification {

  val galleonTotalRedCardPoints = 1
  val galleonTotalBlackCardPoints = 4

  "fighting strength is 3" in {
      val fightingStrength = galleonTotalBlackCardPoints - galleonTotalRedCardPoints
      fightingStrength must_== 3    
  }  

}
