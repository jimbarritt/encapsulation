namespace encapsulation.level_0 {
    using NUnit.Framework;

    [TestFixture]
    public class NoEncapsulationTest
    {

      [Test]
        public void CanCompareForEquality()
        {
            Assert.AreEqual(4, 4);
        }
    }
}