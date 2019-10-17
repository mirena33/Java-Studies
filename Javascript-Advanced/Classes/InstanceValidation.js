class CheckingAccount {
    constructor(clientID, email, firstName, lastName) {
        this.setClientID(clientID);
        this.setEmail(email);
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    nameValidation(value, type) {
        if (value.length < 3 || value.length > 20) {
            throw new TypeError(`${type} name must be between 3 and 20 characters long`);

        } else if (value.match(/^[A-Za-z]+$/g) == null) {
            throw new TypeError(`${type} name must contain only Latin characters`);
        }
    }

    setClientID(clientID) {
        if (typeof Number(clientID) !== "number" || clientID.length !== 6) {
            throw new TypeError('Client ID must be a 6-digit number');
        }
        this.clientID = clientID;
    }

    setEmail(email) {
        if (email.match(/^\w+@[A-Za-z.]+$/g) == null) {
            throw new TypeError('Invalid e-mail');
        }
        this.email = email;
    }

    setFirstName(firstName) {
        this.nameValidation(firstName, `First`);
        this.firstName = firstName;
    }

    setLastName(lastName) {
        this.nameValidation(lastName, `Last`);
        this.lastName = lastName;
    }
}
