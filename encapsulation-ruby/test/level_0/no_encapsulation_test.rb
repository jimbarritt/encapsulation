require "test/unit"
require "level_0/no_encapsulation"
class NoEncapsulationTest < Test::Unit::TestCase

  # How would we deal with more than one galleon?
  def test_can_determine_fighting_strength
    $galleon_total_points_of_black_crew_cards = 3
    $galleon_total_points_of_red_crew_cards = 1

    fighting_strength = $galleon_total_points_of_black_crew_cards - $galleon_total_points_of_red_crew_cards

    assert(fighting_strength, 2)    
  end
end