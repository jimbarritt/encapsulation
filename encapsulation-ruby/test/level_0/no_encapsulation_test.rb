require "test/unit"
require "level_0/no_encapsulation"

class NoEncapsulationTest < Test::Unit::TestCase

  # How would we deal with more than one galleon?
  def test_can_determine_fighting_strength    
    fighting_strength = $galleon_total_points_of_black_cards - $galleon_total_points_of_red_cards

    assert(fighting_strength, 2)    
  end
end