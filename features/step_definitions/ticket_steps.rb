Given /^I am logged in as (.*)$/ do |role|
  # for the moment, do nothing
end

Given /^I am on the "([^"]*)" page/ do |page|
  response.body.should contain("#{page}")
end

When /^I go to the ([^ ]+) page$/ do |page|
  puts "Visiting /#{page}"
  visit "http://localhost:8080/humphries/#{page.downcase}"
end

When /^I click on the "([^"]*)" link$/ do |link|
  click_link link
end

When /^I click on the "([^"]*)" button$/ do |button|
  click_button button
end

When /^I fill "([^"]*)" with "([^"]*)"$/ do |field, value|
  fill_in Regexp.new(field), :with => value
end 

Then /^go to the ([^ ]+) page$/ do |page|
  puts "Visiting /#{page}"
  visit "http://localhost:8080/humphries/#{page.downcase}"
end

Then /^I should see "([^"]*)"$/ do |action|
  response.should contain(action)
end

