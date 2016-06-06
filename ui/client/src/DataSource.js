import qwest from 'qwest';

function DataSource(callback) {
    var dbData = {};
    var baseUrl = '';

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
            dbData['organizations'] = data;

            return qwest.get(baseUrl + '/searches/');
        })
        .then(function (_xhr, data) {
            dbData['searches'] = data;

            if (data.length > 0) {
                return qwest.get(baseUrl + '/match/' + dbData['searches'][0]['id'])
                    .then(function (_xhr, data) {
                        dbData['searches'][0]['matchedCourses'] = data;
                    })
                    .then(function () {
                        callback(dbData);
                    });
            } else {
                callback(dbData);
            }
        })
        .catch(function (msg) {
            console.error('Error during data fetch occured:', msg);
        });
}

export default DataSource;