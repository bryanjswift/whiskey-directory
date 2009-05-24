# Generated by Buildr 1.3.4, change to your liking
require 'buildr/scala'

# Maven 2.0 remote repository
repositories.remote << "http://www.ibiblio.org/maven2/"
# Scala Tools
repositories.remote << 'http://scala-tools.org/repo-releases'
# Google Maven Repository
repositories.remote << 'http://google-maven-repository.googlecode.com/svn/repository/'
# Google Maven Snapshot Repository
repositories.remote << 'http://google-maven-repository.googlecode.com/svn/snapshot-repository/'

# Constants
VERSION_NUMBER = '1.0'
# Dependencies
MYSQL = 'mysql:mysql-connector-java:jar:5.1.5'
JETTY = ['org.mortbay.jetty:jetty-util:jar:7.0.0.pre5','org.mortbay.jetty:jetty:jar:7.0.0.pre5',
	'org.mortbay.jetty:servlet-api:jar:3.0.pre4'
]
SCALA = group('scala-library','scala-compiler',:under => 'org.scala-lang', :version => '2.7.4')
# Testing Dependencies
SPECS = 'org.scala-tools.testing:specs:jar:1.5.0'


desc 'NY Whiskey Directory'
define 'whiskey-directory' do
	gaelibs = FileList[_(ENV['HOME'],'Documents/src/gae','appengine-java-sdk-1.2.1','lib/shared','**/*.jar')]
	DEPS = [JETTY, SCALA] << gaelibs
	TEST_DEPS = [SPECS]

	project.group = 'com.whiskeydirectory'
	project.version = VERSION_NUMBER
	manifest['Copyright'] = 'Bryan J Swift (C) 2009'
	scala = _('src/main/scala')
	compile.using(:warnings => 'true').with DEPS
	test.with DEPS, TEST_DEPS
	test.using :specs
	package :war, :id => 'whiskey-directory'

	task 'package' do |task|
		# After packaging explode the war if you can figure out how
	end

end
