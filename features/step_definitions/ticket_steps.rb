Given /^I am logged in as (.*)$/ do |role|
  # for the moment, do nothing
end

When /^I go to the ([^ ]+) page$/ do |page|
  puts "Visiting /#{page}"
  visit "http://localhost:9000/#{page.downcase}"
end

Then /^I should see "([^"]*)" for "([^"]*)"$/ do |action, entity|
  response.body.should contain(entity)
end

