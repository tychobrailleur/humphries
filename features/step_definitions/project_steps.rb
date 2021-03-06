# -*- coding: utf-8 -*-
#
# Projects steps.
#

# 
When /^I create a project "([^"]+)" with code "([^"]+)"$/ do |name, code|
  visit 'http://localhost:8080/humphries/project/list'
  click_link 'New Project'
  fill_in 'name', :with => name
  fill_in 'code', :with => code
  
  # Description is a string that contains non-ASCII characters
  # to make sure encoding is ok.
  fill_in 'description', :with => 'Lorém Ipsûm dœlor s€€t am¥t'
  click_button 'Create'
end

When /^I add "([^"]+)" as a "([^"]+)" project member$/ do |user, project|
  visit 'http://localhost:8080/humphries/project/list'
  click_link "#{project.downcase}_1"
  click_button 'Edit'
  select user, :from => 'members'
  click_button 'Update'
end

Then /^"([^"]+)" should be in the project list$/ do |project|
  visit 'http://localhost:8080/humphries/project/list'
  response.should contain(project)
end

Then /^"([^"]+)" should be a member of the "([^"]+)" project$/ do |user, project|
  visit 'http://localhost:8080/humphries/project/list'
  click_link "#{project.downcase}_1"
  response.should contain(user)
end
