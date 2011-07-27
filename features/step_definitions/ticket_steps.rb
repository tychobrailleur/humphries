Given /^I am logged in as (.*)$/ do |role|
  # for the moment, do nothing
end

When /^I go to the ([^ ]+) page$/ do |page|
  puts "Visiting /#{page}"
  visit "/#{page}"
end

Then /^I should see "([^"]*)" for "([^"]*)"$/ do |arg1, arg2|
  pending # express the regexp above with the code you wish you had
end

