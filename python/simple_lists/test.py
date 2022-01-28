import unittest

from main import SimpleList


class TestSimpleLists(unittest.TestCase):

    def setUp(self):
        self.__simple_list = SimpleList()

    def test_add(self):
        self.assertEqual(self.__simple_list.size(), 0)
        self.__simple_list.add("value")
        self.assertEqual(self.__simple_list.size(), 1)
        self.assertListEqual(self.__simple_list.values(), ["value"])

    def test_delete(self):
        self.assertEqual(self.__simple_list.size(), 0)
        self.__simple_list.add("1")
        self.assertEqual(self.__simple_list.size(), 1)
        self.__simple_list.delete("2")
        self.assertEqual(self.__simple_list.size(), 1)
        self.__simple_list.delete("1")
        self.assertEqual(self.__simple_list.size(), 0)

    def test_size(self):
        self.assertEqual(self.__simple_list.size(), 0)
        self.__simple_list.add("1")
        self.__simple_list.add("2")
        self.assertEqual(self.__simple_list.size(), 2)
        self.__simple_list.delete("1")
        self.assertEqual(self.__simple_list.size(), 1)

    def test_values(self):
        self.assertEqual(self.__simple_list.values(), [])
        self.__simple_list.add("1")
        self.__simple_list.add("2")
        self.assertEqual(self.__simple_list.values(), ["1", "2"])
        self.__simple_list.delete("1")
        self.assertEqual(self.__simple_list.values(), ["2"])

    def test_is_emtpy(self):
        self.assertEqual(self.__simple_list.is_empty(), True)
        self.__simple_list.add("1")
        self.assertEqual(self.__simple_list.is_empty(), False)
        self.__simple_list.delete("1")
        self.assertEqual(self.__simple_list.is_empty(), True)

    def test_contains(self):
        self.assertEqual(self.__simple_list.contains("5"), False)
        self.__simple_list.add("5")
        self.assertEqual(self.__simple_list.contains("5"), True)
        self.__simple_list.delete("5")
        self.assertEqual(self.__simple_list.contains("5"), False)


if __name__ == '__main__':
    unittest.main()
