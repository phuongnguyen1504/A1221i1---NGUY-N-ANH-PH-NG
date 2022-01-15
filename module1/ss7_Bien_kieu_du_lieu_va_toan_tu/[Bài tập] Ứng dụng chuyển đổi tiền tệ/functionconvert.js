function convert(){
    let amount = Number(document.getElementById('amount').value);
    let fcur = document.getElementById('from').value;
    let tcur = document.getElementById('to').value;
    let exchangerate;
    if (fcur == tcur) {
        exchangerate = 1;
    } else {
        if (fcur == "VND") {
            switch (tcur) {
                case "USD":
                    exchangerate = 0.000044;
                    break;
                case "GBP":
                    exchangerate = 0.000032;
                    break;
                case  "EUR":
                    exchangerate = 0.000039;
                    break;
                case  "AUD":
                    exchangerate = 0.000061;
                    break;
                case "CNY":
                    exchangerate = 0.00028;
                    break;
            }
        }
        if (fcur == "USD") {
            switch (tcur) {
                case "VND":
                    exchangerate = 22716.61;
                    break;
                case "GBP":
                    exchangerate = 0.73;
                    break;
                case  "EUR":
                    exchangerate = 0.88;
                    break;
                case  "AUD":
                    exchangerate = 1.39;
                    break;
                case "CNY":
                    exchangerate = 6.35;
                    break;
            }
        }
        if (fcur == "GBP") {
            switch (tcur) {
                case "VND":
                    exchangerate = 31067.25;
                    break;
                case "USD":
                    exchangerate = 1.37;
                    break;
                case  "EUR":
                    exchangerate = 1.20;
                    break;
                case  "AUD":
                    exchangerate = 1.90;
                    break;
                case "CNY":
                    exchangerate = 8.69;
                    break;
            }
        }
        if (fcur == "EUR") {
            switch (tcur) {
                case "VND":
                    exchangerate = 25931.69;
                    break;
                case "USD":
                    exchangerate = 1.14;
                    break;
                case  "GBP":
                    exchangerate = 0.83;
                    break;
                case  "AUD":
                    exchangerate = 1.58;
                    break;
                case "CNY":
                    exchangerate = 7.25;
                    break;
            }
        }
        if (fcur == "AUD") {
            switch (tcur) {
                case "VND":
                    exchangerate = 16363.20;
                    break;
                case "USD":
                    exchangerate = 0.72;
                    break;
                case  "GBP":
                    exchangerate = 0.53;
                    break;
                case  "EUR":
                    exchangerate = 0.63;
                    break;
                case "CNY":
                    exchangerate = 4.58;
                    break;
            }
        }
        if (fcur == "CNY") {
            switch (tcur) {
                case "VND":
                    exchangerate = 3575.70;
                    break;
                case "USD":
                    exchangerate = 0.16;
                    break;
                case  "GBP":
                    exchangerate = 0.12;
                    break;
                case  "AUD":
                    exchangerate = 0.22;
                    break;
                case "EUR":
                    exchangerate = 0.14;
                    break;
            }
        }
    }
    let result = amount * exchangerate;
    document.getElementById('result').innerHTML = result +" "+ tcur;
}