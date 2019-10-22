const StringBuilder = require("../string-builder.js");
let expect = require("chai").expect;
let assert = require("chai").assert;

describe("String builder", function () {
    it("Can be instantiated without anything", function () {
        let expected = new StringBuilder();
        expect(expected).to.be.a("object");
    });
    it("Can be instantiated with string argument", function () {
        let expected = new StringBuilder("test");
        expect(expected._stringArray).to.have.lengthOf(4);
    });
    it("If functions are attatched to instance", function () {
        let expected = new StringBuilder("test");
        
        expect(expected).to.have.property("prepend");
        expect(expected).to.have.property("append");
        expect(expected).to.have.property("insertAt");
        expect(expected).to.have.property("remove");
        expect(expected).to.have.property("toString");
    });

    it("append(string) if it is working at all", function () {
        let expected = new StringBuilder("test");
        expected.append("demo");
        expect(expected._stringArray).to.have.lengthOf(8);
    });

    it("append(string) at the end of the array", function () {
        let expected = new StringBuilder("TESTE");
        expected.append("D")
        expect(expected._stringArray[expected._stringArray.length - 1]).to.be.equal("D");
    });

    it("apppend(string)  ERROR", function () {
        let expected = new StringBuilder("Tet");
        expect(() => expected.append(2)).to.throw("Argument must be string");
    });

    it("prepend(string) at the beginning of the array", function () {
        let expected = new StringBuilder("TESTE");
        expected.prepend("D")
        expect(expected._stringArray[0]).to.be.equal("D");
    });

    it("prepend(string)  ERROR", function () {
        let expected = new StringBuilder("Tet");
        expect(() => expected.prepend(2)).to.throw("Argument must be string");
    });
    it("insertAt(string, index)", function () {
        let expected = new StringBuilder("Tet");
        expected.insertAt("s", 2);
        expect(expected._stringArray[2]).to.be.equal("s");
    });
    it("insertAt(string, index)", function () {
        let expected = new StringBuilder("Tet");
        expected.insertAt("s", 2);
        expect(expected._stringArray[2]).to.be.equal("s");
    });

    it("insertAt(string, index) ERROR", function () {
        let expected = new StringBuilder("Tet");
        expect(() => expected.insertAt(2, 2)).to.throw("Argument must be string");
    });

    it("remove(startIndex, length) ", function () {
        let expected = new StringBuilder("Test");
        expected.remove(1, 1);
        expect(expected._stringArray[1]).to.be.equal("s");
    });
    it("toString()", function () {
        let expected = new StringBuilder("Test");
        expect(expected.toString()).to.be.equal("Test");
    });
    it("test for throwing error if invalid input", function () {
        expect(() => new StringBuilder(21)).to.Throw("Argument must be string");
    });
})
