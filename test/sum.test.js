const { sum } = require('../app/src/index');
const assert = require('assert');

describe('Sum function', () => {
    it('should return 5 for 2 + 3', () => {
        assert.equal(sum(2, 3), 5);
    });

    it('should return 0 for 0 + 0', () => {
        assert.equal(sum(0, 0), 0);
    });

    it('should return -1 for -2 + 1', () => {
        assert.equal(sum(-2, 1), -1);
    });

    it('should handle floating point numbers', () => {
        assert.equal(sum(1.5, 2.5), 4);
    });
});