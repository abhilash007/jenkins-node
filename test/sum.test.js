const { sum } = require('../app/src/index');
const { expect } = require('chai');

describe('Sum function', () => {
    it('should return 5 for 2 + 3', () => {
        expect(sum(2, 3)).to.equal(5);
    });

    it('should return 0 for 0 + 0', () => {
        expect(sum(0, 0)).to.equal(0);
    });

    it('should return -1 for -2 + 1', () => {
        expect(sum(-2, 1)).to.equal(-1);
    });

    it('should handle floating point numbers', () => {
        expect(sum(1.5, 2.5)).to.equal(4);
    });
});