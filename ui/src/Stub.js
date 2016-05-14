console.error('Warning: you are currently importing stub data. Be aware that in production mode you will need an API for that.');

export default {
    organizations: [
                { id: '1', title: 'Munich Technological University', description: 'Munich ist der gut! Deutsch ist der gut!', url: 'http://google.com/search?q=Munich Technological University' },
                { id: '2', title: 'FHWien der WKW', description: 'Vienn is beautiful', url: 'http://google.com/search?q=FHWien der WKW' },
                { id: '3', title: 'EPAM Java Academy', description: 'EPAM provides great production experience and salaries', url: 'http://google.com/search?q=EPAM Java Academy' },
                { id: '4', title: 'Massachussets University Of Technology', description: 'Go for USA!', url: 'http://google.com/search?q=Massachussets University Of Technology' },
                { id: '5', title: 'Uniwersytet Jagielloński', description: 'Kraków is awesome! UJ provides great theoretical knowledge on IT.', url: 'http://google.com/search?q=Uniwersytet Jagielloński' },
                { id: '6', title: 'Akademia Górniczo-Huthicza', description: 'AGH provides awesome practical knowledge', url: 'http://google.com/search?q=Akademia Górniczo-Huthicza' },
                { id: '7', title: 'University Of Cambridge', description: 'This is Cambridge.', url: 'http://google.com/search?q=University Of Cambridge' },
                { id: '8', title: 'Politechnika Wrocławska', description: 'Wrocław is the cultural centre of Poland', url: 'http://google.com/search?q=Politechnika Wrocławska' }
            ],

    questions: [
                { title: 'question 1', imgUrl: 'https://unsplash.it/200/100?image=1&blur', style: 'SINGLE_CHOICE', options: [{ optionId: 'q1o1', value: 'option 1' }, { optionId: 'q1o2', value: 'option 2' }, { optionId: 'q1o3', value: 'option 3' }] },
                { title: 'q2', imgUrl: 'https://unsplash.it/200/100?image=2&blur', style: 'MULTIPLE_CHOICE', options: [{ optionId: 'q2o1', value: 'option #1' }, { optionId: 'q2o2', value: 'option #2' }, { optionId: 'q2o3', value: 'option #3' }] },
                { title: 'quuuestion 3', imgUrl: 'https://unsplash.it/200/100?image=3&blur', style: 'SINGLE_CHOICE', options: [{ optionId: 'q3o1', value: 'option ##1' }, { optionId: 'q3o2', value: 'option ##2' }, { optionId: 'q3o3', value: 'option ##3' }] }
            ],

    searches: [
                { id: '1', createdAt: '2016-04-12', matchedOrgs: [ { id: '1', title: 'Munich Technological University' }, { id: '2', title: 'FHWien der WKW' }, { id: '3', title: 'EPAM Java Academy' } ], answers: [
                    { question: { title: 'question 1', imgUrl: 'https://unsplash.it/200/100?image=1&blur', style: 'SINGLE_CHOICE', options: [{ optionId: 'q1o1', value: 'option 1' }, { optionId: 'q1o2', value: 'option 2' }, { optionId: 'q1o3', value: 'option 3' }] }, answer: ['q1o2'] },
                    { question: { title: 'q2', imgUrl: 'https://unsplash.it/200/100?image=2&blur', style: 'MULTIPLE_CHOICE', options: [{ optionId: 'q2o1', value: 'option #1' }, { optionId: 'q2o2', value: 'option #2' }, { optionId: 'q2o3', value: 'option #3' }] }, answer: ['q2o1', 'q2o2'] },
                    { question: { title: 'quuuestion 3', imgUrl: 'https://unsplash.it/200/100?image=3&blur', style: 'SINGLE_CHOICE', options: [{ optionId: 'q3o1', value: 'option ##1' }, { optionId: 'q3o2', value: 'option ##2' }, { optionId: 'q3o3', value: 'option ##3' }] }, answer: ['q3o3'] },
                    { question: { title: 'quuuestion 4', imgUrl: 'https://unsplash.it/200/100?image=4&blur', style: 'SINGLE_CHOICE', options: [{ optionId: 'q3o1', value: 'option ##1' }, { optionId: 'q3o2', value: 'option ##2' }, { optionId: 'q3o3', value: 'option ##3' }] }, answer: ['q3o1'] },
                    { question: { title: 'quuuestion 5', imgUrl: 'https://unsplash.it/200/100?image=5&blur', style: 'SINGLE_CHOICE', options: [{ optionId: 'q3o1', value: 'option ##1' }, { optionId: 'q3o2', value: 'option ##2' }, { optionId: 'q3o3', value: 'option ##3' }] }, answer: ['q3o2'] }
                ] },

                { id: '2', createdAt: '2016-05-07', matchedOrgs: [ { id: '4', title: 'Massachussets University Of Technology' }, { id: '5', title: 'Uniwersytet Jagielloński' }, { id: '6', title: 'Akademia Górniczo-Huthicza' }, { id: '7', title: 'University Of Cambridge' } ], answers: [
                    { question: { title: 'question 1', imgUrl: 'https://unsplash.it/200/100?image=1&blur', style: 'SINGLE_CHOICE', options: [{ optionId: 'q1o1', value: 'option 1' }, { optionId: 'q1o2', value: 'option 2' }, { optionId: 'q1o3', value: 'option 3' }] }, answer: ['q1o2'] },
                    { question: { title: 'q2', imgUrl: 'https://unsplash.it/200/100?image=2&blur', style: 'MULTIPLE_CHOICE', options: [{ optionId: 'q2o1', value: 'option #1' }, { optionId: 'q2o2', value: 'option #2' }, { optionId: 'q2o3', value: 'option #3' }] }, answer: ['q2o1', 'q2o2'] },
                    { question: { title: 'quuuestion 3', imgUrl: 'https://unsplash.it/200/100?image=3&blur', style: 'SINGLE_CHOICE', options: [{ optionId: 'q3o1', value: 'option ##1' }, { optionId: 'q3o2', value: 'option ##2' }, { optionId: 'q3o3', value: 'option ##3' }] }, answer: ['q3o3'] },
                    { question: { title: 'quuuestion 4', imgUrl: 'https://unsplash.it/200/100?image=4&blur', style: 'SINGLE_CHOICE', options: [{ optionId: 'q3o1', value: 'option ##1' }, { optionId: 'q3o2', value: 'option ##2' }, { optionId: 'q3o3', value: 'option ##3' }] }, answer: ['q3o1'] },
                    { question: { title: 'quuuestion 5', imgUrl: 'https://unsplash.it/200/100?image=5&blur', style: 'SINGLE_CHOICE', options: [{ optionId: 'q3o1', value: 'option ##1' }, { optionId: 'q3o2', value: 'option ##2' }, { optionId: 'q3o3', value: 'option ##3' }] }, answer: ['q3o2'] }
                ] },

                { id: '3', createdAt: '2016-05-14', matchedOrgs: [ { id: '8', title: 'Politechnika Wrocławska' }, { id: '6', title: 'Akademia Górniczo-Huthicza'}, { id: '5', title: 'Uniwersytet Jagielloński' } ], answers: [
                    { question: { title: 'question 1', imgUrl: 'https://unsplash.it/200/100?image=1&blur', style: 'SINGLE_CHOICE', options: [{ optionId: 'q1o1', value: 'option 1' }, { optionId: 'q1o2', value: 'option 2' }, { optionId: 'q1o3', value: 'option 3' }] }, answer: ['q1o2'] },
                    { question: { title: 'q2', imgUrl: 'https://unsplash.it/200/100?image=2&blur', style: 'MULTIPLE_CHOICE', options: [{ optionId: 'q2o1', value: 'option #1' }, { optionId: 'q2o2', value: 'option #2' }, { optionId: 'q2o3', value: 'option #3' }] }, answer: ['q2o1', 'q2o2'] },
                    { question: { title: 'quuuestion 3', imgUrl: 'https://unsplash.it/200/100?image=3&blur', style: 'SINGLE_CHOICE', options: [{ optionId: 'q3o1', value: 'option ##1' }, { optionId: 'q3o2', value: 'option ##2' }, { optionId: 'q3o3', value: 'option ##3' }] }, answer: ['q3o3'] },
                    { question: { title: 'quuuestion 4', imgUrl: 'https://unsplash.it/200/100?image=4&blur', style: 'SINGLE_CHOICE', options: [{ optionId: 'q3o1', value: 'option ##1' }, { optionId: 'q3o2', value: 'option ##2' }, { optionId: 'q3o3', value: 'option ##3' }] }, answer: ['q3o1'] },
                    { question: { title: 'quuuestion 5', imgUrl: 'https://unsplash.it/200/100?image=5&blur', style: 'SINGLE_CHOICE', options: [{ optionId: 'q3o1', value: 'option ##1' }, { optionId: 'q3o2', value: 'option ##2' }, { optionId: 'q3o3', value: 'option ##3' }] }, answer: ['q3o2'] }
                ] }
            ]
}