const yaml = require('js-yaml');
const config = yaml.load(require('fs').readFileSync('app/config/stage-variables.yml', 'utf8'));
const STAGE = 'dev';
const envVars = config[STAGE]['EnvVariables'];



// for (const [key, value] of Object.entries(envVars)) {
//     process.env[key] = value.toString();
// }

for (const key in envVars) {
// console.log(key);
 process.env[key] = envVars[key].toString();
 console.log(`${key}: ${process.env[key]}`);
 

}

// console.log("--- Starting application ---");
// console.log("STAGE: " + process.env.STAGE);
// console.log("DB_USER_NAME: " + process.env.DB_USER_NAME);
// console.log("DB_PASSWORD: " + process.env.DB_PASSWORD);
// console.log("--- Application ended ---");
// // console.log(envVars);;l

function sum(a, b) {
    return a + b;
}

module.exports = { sum };








