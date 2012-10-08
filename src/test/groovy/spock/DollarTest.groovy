package spock

import spock.lang.Specification

class DollarTest extends Specification {

    def testMultiplication() {
        setup:
            Money five = Money.dollar(5)
            Money product = five.times 2
            assert product == Money.dollar(10)
        when:
            product = five.times 3
        then:
            assert product == Money.dollar(15)
    }

    def testEquality() {
        expect:
            assert Money.dollar(5).equals(Money.dollar(5)) == true
            assert Money.dollar(5).equals(Money.dollar(6)) == false
            assert Money.franc(5).equals(Money.franc(5)) == true
            assert Money.franc(5).equals(Money.franc(6)) == false
            assert Money.dollar(5).equals(Money.franc(5)) == false
    }

    def testFruncMultiplication() {
        setup:
            Franc five = Money.franc(5)
        expect:
            assert five.times(2) == Money.franc(10)
            assert five.times(3) == Money.franc(15)
    }
    
    def testCurrency() {
        expect:
            assert Money.dollar(1).currency() == "USD"
            assert Money.franc(1).currency() == "CHF"
    }
    
    def testDiffrentClassEquality() {
        expect:
            assert new Money(10, "CHF").equals(new Franc(10, "CHF"))
    }
}