const yaml = require('js-yaml');
const config = yaml.load(require('fs').readFileSync('app/config/stage-variables.yml', 'utf8'));

const envVars = config[process.env.STAGE]['EnvVariables'];
console.log("--- Starting application ---");
console.log("STAGE: " + process.env.STAGE);
console.log("DB_USER_NAME: " + process.env.DB_USER_NAME);
console.log("DB_PASSWORD: " + process.env.DB_PASSWORD);
console.log("--- Application ended ---");
console.log(envVars);

