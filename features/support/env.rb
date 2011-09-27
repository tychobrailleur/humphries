require 'rspec'
require 'htmlentities'
require "webrat/selenium"

Webrat.configure do |config|
  config.mode = :selenium
  config.selenium_browser_key = ENV['SELENIUM_BROWSER'] || "*firefox"
  config.selenium_server_address = 'localhost'
  config.application_framework = :external
  config.application_address = 'localhost'
  config.application_port = 8080
#  config.selenium_verbose_output = true # Prints out HTML if needed.
end

#this is necessary to have webrat "wait_for" the response body to be available
#when writing steps that match against the response body returned by selenium
World(Webrat::Selenium::Matchers)
