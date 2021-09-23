from math import sqrt


class PrimeFactors:

    __result = []
    __number = 0

    def resolve(self, number):
        self.__result = []
        self.__number = number
        if not type(self.__number) is int or self.__number <= 0:
            raise TypeError("Number must be a positive integer")

        if self.__number <= 2:
            return [self.__number]

        self.__determine_twos()
        self.__determine_odds()

        return self.__result

    def __determine_twos(self):
        while self.__number & 1 == 0:
            self.__number >>= 1
            self.__result.append(2)

    def __determine_odds(self):
        root = int(sqrt(self.__number))
        for divisor in range(3, root, 2):
            while self.__number % divisor == 0:
                self.__number /= divisor
                self.__result.append(divisor)

        if self.__number > 2:
            self.__result.append(self.__number)
