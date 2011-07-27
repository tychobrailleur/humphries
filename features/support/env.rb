require 'rubygems'
require 'webrat'
require 'webrat/selenium'

Webrat.configure do |config|
  config.mode = :selenium
  config.selenium_server_address = 'localhost'
  config.selenium
  config.application_framework = :external
  config.application_port = 9000
end

World(Webrat::Methods)
World(Webrat::Matchers)
World(Webrat::Selenium::Matchers)

