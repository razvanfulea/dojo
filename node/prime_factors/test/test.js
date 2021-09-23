var assert = require('assert');
var primeFactors = require('../index.js');

describe('Prime Factors', () => {

    it('should throw error for non numbers', () => {
        assert.throws(() => primeFactors("1000"), TypeError);
        assert.throws(() => primeFactors("-1000"), TypeError);
        assert.throws(() => primeFactors(""), TypeError);
        assert.throws(() => primeFactors(new Date()), TypeError);
        assert.throws(() => primeFactors({}), TypeError);
        assert.throws(() => primeFactors([]), TypeError);
        assert.throws(() => primeFactors(undefined), TypeError);
        assert.throws(() => primeFactors(null), TypeError);
    });

    it('should throw error for zero or negative', () => {
        assert.throws(() => primeFactors(0), TypeError);
        assert.throws(() => primeFactors(-1), TypeError);
        assert.throws(() => primeFactors(-1000), TypeError);
    });

    it('should work for one', () => {
        assert.deepEqual([1], primeFactors(1))
    });

    it('should work for two', () => {
        assert.deepEqual([2], primeFactors(2));
    });

    it('should work for primes', () => {
        assert.deepEqual([13], primeFactors(13));
        assert.deepEqual([39821], primeFactors(39821));
    });

    it('should work for non primes', () => {
        assert.deepEqual([2, 3, 5, 7, 13], primeFactors(2730));
        assert.deepEqual([3, 3, 3], primeFactors(27));
        assert.deepEqual([13, 17], primeFactors(221));
    });

    it('should work for powers of two', () => {
        assert.deepEqual(Array(16).fill(2), primeFactors(65536));
    });

})