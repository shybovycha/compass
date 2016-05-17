import qwest from 'qwest';

function DataSource(callback) {
    var dbData = {};
    var baseUrl = 'http://localhost:8080';

    qwest.get(baseUrl + '/courses/')
        .then(function (_xhr, data) {
            dbData['courses'] = data;

            return qwest.get(baseUrl + '/questions/');
        })
        .then(function (_xhr, data) {
            dbData['questions'] = data;

            return qwest.get(baseUrl + '/orgs/');
        })
        .then(function (_xhr, data) {
            dbData['orgs'] = data;

            return qwest.get(baseUrl + '/searches/');
        })
        .then(function (_xhr, data) {
            dbData['searches'] = data;

            callback(dbData);
        })
        .catch(function (msg) {
            console.error('Error during data fetch occured:', msg);
        });
}

export default DataSource;