require "test/unit"
require "level_0/no_encapsulation"

class NoEncapsulationTest < Test::Unit::TestCase

  # How would we deal with more than one galleon?
  def test_can_determine_fighting_strength    
    fighting_strength = 2;
    assert(fighting_strength, 2)
  end
end