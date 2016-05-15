console.error('Warning: you are currently importing stub data. Be aware that in production mode you will need an API for that.');

export default {
    organizations: [
                { id: '1', title: 'Munich Technological University', description: 'Munich ist der gut! Deutsch ist der gut!', url: 'http://google.com/search?q=Munich Technological University', courses: [ '1', '2', '3' ] },
                { id: '2', title: 'FHWien der WKW', description: 'Vienn is beautiful', url: 'http://google.com/search?q=FHWien der WKW', courses: [ '1', '2', '3', '4' ] },
                { id: '3', title: 'EPAM Java Academy', description: 'EPAM provides great production experience and salaries', url: 'http://google.com/search?q=EPAM Java Academy', courses: [ '1' ] },
                { id: '4', title: 'Massachussets University Of Technology', description: 'Go for USA!', url: 'http://google.com/search?q=Massachussets University Of Technology', courses: [ '1', '2', '3', '4', '6' ] },
                { id: '5', title: 'Uniwersytet Jagielloński', description: 'Kraków is awesome! UJ provides great theoretical knowledge on IT.', url: 'http://google.com/search?q=Uniwersytet Jagielloński', courses: [ '1', '2', '3', '4', '5' ] },
                { id: '6', title: 'Akademia Górniczo-Huthicza', description: 'AGH provides awesome practical knowledge', url: 'http://google.com/search?q=Akademia Górniczo-Huthicza', courses: [ '1', '2', '3', '4' ] },
                { id: '7', title: 'University Of Cambridge', description: 'This is Cambridge.', url: 'http://google.com/search?q=University Of Cambridge', courses: [ '2', '4', '5' ] },
                { id: '8', title: 'Politechnika Wrocławska', description: 'Wrocław is the cultural centre of Poland', url: 'http://google.com/search?q=Politechnika Wrocławska', courses: [ '1', '2', '4' ] }
            ],

    questions: [
                { id: '1', title: 'question 1', imgUrl: 'https://unsplash.it/200/100?image=1&blur', style: 'SINGLE_CHOICE', options: [{ optionId: 'q1o1', value: 'option 1' }, { optionId: 'q1o2', value: 'option 2' }, { optionId: 'q1o3', value: 'option 3' }] },
                { id: '2', title: 'q2', imgUrl: 'https://unsplash.it/200/100?image=2&blur', style: 'MULTIPLE_CHOICE', options: [{ optionId: 'q2o1', value: 'option #1' }, { optionId: 'q2o2', value: 'option #2' }, { optionId: 'q2o3', value: 'option #3' }] },
                { id: '3', title: 'quuuestion 3', imgUrl: 'https://unsplash.it/200/100?image=3&blur', style: 'SINGLE_CHOICE', options: [{ optionId: 'q3o1', value: 'option ##1' }, { optionId: 'q3o2', value: 'option ##2' }, { optionId: 'q3o3', value: 'option ##3' }] }
            ],

    searches: [
                { id: '1', createdAt: '2016-04-12', matchedCourses: [ '1', '2', '3' ], answers: [
                    { question: '1', answer: ['q1o2'] },
                    { question: '2', answer: ['q2o1', 'q2o2'] },
                    { question: '3', answer: ['q3o3'] },
                    { question: '2', answer: ['q2o1'] },
                    { question: '1', answer: ['q1o2'] }
                ] },

                { id: '2', createdAt: '2016-05-07', matchedCourses: [ '5', '6' ], answers: [
                    { question: '1', answer: ['q1o2'] },
                    { question: '2', answer: ['q2o1', 'q2o2'] },
                    { question: '3', answer: ['q3o3'] }
                ] },

                { id: '3', createdAt: '2016-05-14', matchedCourses: [ '1', '4', '5' ], answers: [
                    { question: '1', answer: ['q1o2'] },
                    { question: '2', answer: ['q2o1', 'q2o2'] },
                    { question: '3', answer: ['q3o3'] }
                ] }
            ],

    courses: [
                { id: '1', title: 'Software Engineering', description: 'Here you will learn how to create complex and cool software and websites.' },
                { id: '2', title: 'Computer Science', description: 'This teaches you to refine and discover new or existing algorithms.' },
                { id: '3', title: 'Bioinformatics', description: 'You will learn how to help biologists to discover human body functions and structure or even make medical tests with computer software, you have made.' },
                { id: '4', title: 'Applied mathematics', description: 'Here you will be tought how to use maths for real-world problems.' },
                { id: '5', title: 'Eastern cultures', description: 'You will get close to Japan, China, Korea and all their mystic cultures and languages.' },
                { id: '6', title: 'Nuclear physics', description: 'Want to work for nuclear power units? Or even develop a brand-new one? That is the place for you!' }
            ],

    user: {
                name: "USERNAME",
                email: "user@email.com",
                imgUrl: `https://randomuser.me/api/portraits/med/women/${ Math.floor(Math.random() * 100) }.jpg`
            }
}