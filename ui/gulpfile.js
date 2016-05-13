var gulp = require('gulp');
var source = require('vinyl-source-stream'); // Used to stream bundle for further handling
var browserify = require('browserify');
var gutil = require('gulp-util');
//var watchify = require('watchify');
//var reactify = require('reactify');
//var concat = require('gulp-concat');

gulp.task('browserify', function() {
    var bundler = browserify({
	entries: './src/App.jsx',
	debug: true,
	extensions: ['.jsx'] 
    });

    bundler
	.transform("babelify", { presets: ["es2015", "react"] })
	.bundle()
	.on('error', gutil.log)
	.pipe(source('bundle.js'))
	.pipe(gulp.dest('./build'));
});

// Just running the two tasks
gulp.task('default', ['browserify']);
