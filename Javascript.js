// Primitive and Reference Type
const number = 1 ; // Primitive
const num2 = number; // Since primitive it copies the value

console.log(num2); // Numbers, strings, booleans

const person = {
    name: 'Max'
};

const thirdPerson = {
    //...person      <- - wont change properties of the main type
};

console.log (thirdPerson);

const secondPerson = person;
console.log(secondPerson);
// To remember it just copies the pointer so
// if you change a property the whole class changes
person.name = 'Menu';
console.log(secondPerson);

const numbers = [1,2,3];
const doubleNumArray = numbers.map((num) => {
    return num * 2 // -> Doubles
});

console.log(numbers);
console.log(doubleNumArray);
