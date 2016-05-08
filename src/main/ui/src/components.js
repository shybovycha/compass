class QuestionOption extends React.Component {
	static propTypes = {
		title: React.PropTypes.string.isRequired,
		image: React.PropTypes.string,
		value: React.PropTypes.any.isRequired,
		onSelect: React.PropTypes.func
	}

	constructor(props) {
		super(props);

		this.state = {
			isSelected: false
		};
	}

	onSelectClicked() {
		this.state.isSelected = !this.state.isSelected;

		if (this.props.onSelect)
			this.props.onSelect();
	}

	render() {
		var title = this.props.title,
			imageUrl = this.props.image,
			image = null;

		if (imageUrl)
			image = (
				<div className="image">
					<img src={ image } />
				</div>
			);

		return (
			<div className="option">
				{ image }
				<button className="select" onClick={ () => this.onSelectClicked() }>{ title }</button>
			</div>
		);
	}
}

class Question extends React.Component {
	static propTypes = {
		title: React.PropTypes.string.isRequired,
		children: React.PropTypes.arrayOf(React.PropTypes.instanceOf(QuestionOption)).isRequired
	}

	constructor(props) {
		super(props);

		this.state = {
			selectedOptions: []
		};
	}

	selectOption(opt) {
		this.state.selectedOptions = [opt];
	}

	render() {
		var title = this.props.title,
			options = React.Children.map(this.props.children, (opt) => {
				return <QuestionOption {...opt.props} onSelect={ (opt) => this.selectOption(opt) } />
			});

		return (
			<div className="question">
				<div className="title">{ title }</div>

				{ options }
			</div>
		);
	}
}

class Questionnaire extends React.Component {
	static propTypes = {
		children: React.PropTypes.arrayOf(Question).isRequired
	}

	constructor(props) {
		super(props);

		this.state = {
			questionCount: props.children.length,
			currentQuestionIdx: 0
		};
	}

	currentQuestion() {
		return this.props.children[this.state.currentQuestionIdx];
	}

	prevQuestion() {
		this.setState({ currentQuestionIdx: (this.state.currentQuestionIdx - 1) % this.state.questionCount });
	}

	nextQuestion() {
		this.setState({ currentQuestionIdx: (this.state.currentQuestionIdx - 1) % this.state.questionCount });
	}

	render() {
		var question = this.currentQuestion();

		return (
			<div className="questionnaire">
				<button onClick={ () => this.prevQuestion() }>Previous Question</button>

				<Question {...question} />

				<button onClick={ () => this.nextQuestion() }>Next Question</button>
			</div>
		);
	}
}

window.onload = () => {
	ReactDOM.render(
		<Questionnaire>
		    <Question title="How many stars do you have?">
			    <QuestionOption title="1" value="1" />
			    <QuestionOption title="2" value="2" />
			    <QuestionOption title="3" value="3" />
			</Question>
		  
		    <Question title="How many stars would you like to have?">
			    <QuestionOption title="1" value="1" />
			    <QuestionOption title="2" value="2" />
			    <QuestionOption title="3" value="3" />
		    </Question>
		</Questionnaire>
		, document.querySelector('#app-container')
	);
};