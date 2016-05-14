var gulp = require('gulp');
var source = require('vinyl-source-stream'); // Used to stream bundle for further handling
var browserify = require('browserify');
var gutil = require('gulp-util');
var watchify = require('watchify');
//var reactify = require('reactify');
//var concat = require('gulp-concat');

var browserifyOptions = Object.assign(watchify.args, {
    entries: './src/App.jsx',
    debug: true,
    extensions: ['.jsx']
});

function bundle(bundler) {
    return function () {
        console.log('Rebuilding...');

        return bundler
            .transform("babelify", { presets: ["es2015", "react"] })
            .bundle()
            .on('error', gutil.log)
            .pipe(source('bundle.js'))
            .pipe(gulp.dest('./build'));
    }
}

watcher = watchify(browserify(browserifyOptions));

watcher.on('update', bundle(watcher))

gulp.task('default', bundle(watcher));
