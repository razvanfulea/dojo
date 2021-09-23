import unittest

from main import PrimeFactors


class TestFoo(unittest.TestCase):

    __prime_factors = None

    def setUp(self):
        self.__prime_factors = PrimeFactors()

    def test_zeroOrNegativeThrowsError(self):
        self.assertRaises(TypeError, self.__prime_factors.resolve, 0)
        self.assertRaises(TypeError, self.__prime_factors.resolve, -1)
        self.assertRaises(TypeError, self.__prime_factors.resolve, -1000)

    def test_nonIntegerThrowsError(self):
        self.assertRaises(TypeError, self.__prime_factors.resolve, "abc")
        self.assertRaises(TypeError, self.__prime_factors.resolve, 1.5)

    def test_one(self):
        actual = self.__prime_factors.resolve(1)
        expected = [1]
        self.assertEqual(expected, actual)

    def test_two(self):
        actual = self.__prime_factors.resolve(2)
        expected = [2]
        self.assertEqual(expected, actual)

    def test_primes(self):
        actual = self.__prime_factors.resolve(13)
        expected = [13]
        self.assertEqual(expected, actual)

    def test_nonPrimes(self):
        actual = self.__prime_factors.resolve(2730)
        expected = [2, 3, 5, 7, 13]
        self.assertEqual(expected, actual)

    def test_powerOfTwo(self):
        actual = self.__prime_factors.resolve(65536)
        expected = [2 for _ in range(0, 16)]
        self.assertEqual(expected, actual)


if __name__ == '__main__':
    unittest.main()
