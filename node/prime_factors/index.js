let result = [];
let number;

function primeFactors(n) {
    number = n;
    result = [];

    if (isNaN(number) || !Number.isInteger(number) || number < 1) {
        throw TypeError("Number should be a positive integer!");
    }
    if (number <= 2) {
        return [number];
    }

    determineTwos();
    determineOdds();
    
    return result;
}

function determineTwos() {
    while ((number & 1) == 0) {
        number >>= 1;
        result.push(2);
    }
}

function determineOdds() {
    const root = Math.sqrt(number);
    for (let divisor = 3; divisor < root; divisor += 2) {
        while (number % divisor == 0) {
            number /= divisor;
            result.push(divisor);
        }
    }

    if (number > 2) {
        result.push(number);
    }
}

module.exports = primeFactors;