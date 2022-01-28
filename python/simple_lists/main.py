class SimpleList:

    def __init__(self):
        self.__elements = []

    def add(self, value):
        self.__elements.append(value)

    def delete(self, value):
        if value in self.__elements:
            self.__elements.remove(value)

    def size(self):
        return len(self.__elements)

    def values(self):
        return self.__elements

    def is_empty(self):
        return len(self.__elements) == 0

    def contains(self, value):
        return value in self.__elements
