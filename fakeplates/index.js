const faker = require('faker');
const fs = require('fs');

(async () => {
    try {
        let data = "";
        for (let i = 0; i < 100000; i++) {
            data += faker.fake("{{helpers.replaceSymbols(???###)}},{{commerce.color}}\r\n");
        }

        await fs.appendFile("generated.txt", data, error => {
            if (error) {
                console.log("something went wrong");
            }
        });

    } catch (e) {
        // Deal with the fact the chain failed
    }
})();

